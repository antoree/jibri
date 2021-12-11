package org.jitsi.jibri;
import org.jitsi.jibri.util.LoggingDoannh;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.core.SdkResponse;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.io.File;
/**
 * created by: Nguyen Huy Doan
 * at: 12/11/2021 1:53 PM
 */
public class AwsS3Util {
    private static final String S3_BUCKET_NAME = "antoree-vc-j3i-record";
    private static final String S3_DOMAIN ="https://antoree-vc-j3i-record.s3-ap-southeast-1.amazonaws.com/";

    public static String uploadFile(String filePath) {
        try {
            File f = new File(filePath);
            //
            Region region = Region.AP_SOUTHEAST_1;
            S3Client s3 = S3Client.builder()
                    .credentialsProvider(() -> new AwsCredentials() {
                        @Override
                        public String accessKeyId() {
                            return "1";
                        }

                        @Override
                        public String secretAccessKey() {
                            return "1";
                        }
                    })
                    .region(region)
                    .build();

            PutObjectRequest objectRequest = PutObjectRequest.builder()
                    .bucket(S3_BUCKET_NAME)
                    .key(f.getName())
                    .build();
            s3.putObject(objectRequest, f.toPath());
            return S3_DOMAIN+f.getName();
        } catch (Exception e) {
            e.printStackTrace();
            LoggingDoannh.Companion.log("ERROR IN UPLOAD TO S3: " + e.getMessage());
            return "ERROR";
        }
    }
}