package message.email;

public class File {

    private final String fileName, fileType;

    public File(String fileName, String fileType) throws IllegalArgumentException{
        if (fileName == null || fileType == null || fileName.isBlank() || fileType.isBlank()){
            throw new IllegalArgumentException("file or type is null or empty");
        }
        this.fileName = fileName;
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileType() {
        return fileType;
    }

    @Override
    public String toString() {
        return fileName + ":" + fileType;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof File file)){
            return false;
        }
        return file.fileName.equals(fileName) && file.fileType.equals(fileType);
    }
}
