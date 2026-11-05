package message.email;

public class File {

    private final String fileName, fileType;

    public File(String fileName, String fileType){
        this.fileName = fileName;
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileType() {
        return fileType;
    }
}
