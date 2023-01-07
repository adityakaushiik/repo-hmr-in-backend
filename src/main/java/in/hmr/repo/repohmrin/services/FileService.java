package in.hmr.repo.repohmrin.services;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileService {
    private String TEMP_URL = "";
    private String DOWNLOAD_URL = "https://firebasestorage.googleapis.com/v0/b/repo-hmr-in.appspot.com/o/%s?alt=media";

    public String[] upload(MultipartFile multipartFile) {
        try {
            String fileName = multipartFile.getOriginalFilename();                        // to get original file name
            String fileId = UUID.randomUUID().toString();
            fileName = fileId.concat(this.getExtension(fileName));                        // to generated random string values for file name.

            File file = this.convertToFile(multipartFile, fileName);                      // to convert multipartFile to File
            TEMP_URL = this.uploadFile(file, fileName);                                   // to get uploaded file link
            file.delete();                                                                // to delete the copy of uploaded file stored in the project folder
            return new String[]{fileId,fileName};                                         // Your customized response
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String[]{"NA", "Unable To Get File"};
    }

    public JsonObject download(String fileName) throws IOException {
        String destFileName = UUID.randomUUID().toString().concat(this.getExtension(fileName));     // to set random string for destination file name
        String destFilePath = "Downloads/" + destFileName;                                          // to set destination file path

        ////////////////////////////////   Download   ////////////////////////////////////////////////////////////////////////
        Credentials credentials = GoogleCredentials.fromStream(
                new FileInputStream("src/main/resources/repo-hmr-in-firebase-adminsdk-l9a71-2cd68c5af6.json"));
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        Blob blob = storage.get(BlobId.of("repo-hmr-in.appspot.com", fileName));
        blob.downloadTo(Paths.get(destFilePath));
        return sendResponse("200", "Successfully Downloaded!");
    }

    private String uploadFile(File file, String fileName) throws IOException {
        BlobId blobId = BlobId.of("repo-hmr-in.appspot.com", fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build();
        Credentials credentials = GoogleCredentials.fromStream(
                new FileInputStream("src/main/resources/repo-hmr-in-firebase-adminsdk-l9a71-2cd68c5af6.json"));
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        storage.create(blobInfo, Files.readAllBytes(file.toPath()));

        return String.format(DOWNLOAD_URL, URLEncoder.encode(fileName, StandardCharsets.UTF_8));
    }

    private File convertToFile(MultipartFile multipartFile, String fileName) throws IOException {
        File tempFile = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(multipartFile.getBytes());
            fos.close();
        }
        return tempFile;
    }

    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    private JsonObject sendResponse(String s, String s1) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("status", s);
        jsonObject.addProperty("description", s1);
        return jsonObject;
    }
}
