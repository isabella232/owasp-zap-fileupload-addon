/**
 * Copyright 2020 SasanLabs
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 * <p>http://www.apache.org/licenses/LICENSE-2.0
 *
 * <p>Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sasanlabs.fileupload.attacks.beans;

import java.util.Date;
import java.util.Random;
import org.sasanlabs.fileupload.attacks.FileUploadException;

/**
 * {@code FileParameter} class is used to represent the file object ...
 *
 * @author KSASAN preetkaran20@gmail.com
 */
public class FileParameter {

    private String baseFileName;
    private String extension;
    private String contentType;
    private FileExtensionOperation fileExtensionOperation =
            FileExtensionOperation.ONLY_PROVIDED_EXTENSION;

    public FileParameter(String extension, String contentType) {
        super();
        this.baseFileName = String.valueOf(new Random(new Date().getTime()).nextLong());
        this.extension = extension;
        this.contentType = contentType;
    }

    public FileParameter(
            String extension, String contentType, FileExtensionOperation fileExtensionOperation) {
        super();
        this.baseFileName = String.valueOf(new Random(new Date().getTime()).nextLong());
        this.extension = extension;
        this.contentType = contentType;
        this.fileExtensionOperation = fileExtensionOperation;
    }

    public String getContentType() {
        return contentType;
    }

    public String getFileName(String originalFileName, String newBaseFileName)
            throws FileUploadException {
        return String.valueOf(newBaseFileName)
                + this.baseFileName
                + FileExtensionOperation.appendPeriodCharacter(
                        fileExtensionOperation.operator(this.extension, originalFileName));
    }
}
