public enum Configuration
{
    instance;

    public String fileSeparator = System.getProperty("file.separator");
    public String userDirectory = System.getProperty("user.dir");

    public String nameOfSubFolder = "component" + fileSeparator + "jar";
    public String nameOfJavaArchive = "MountainPrime.jar";
    public String subFolderPathOfJavaArchive = nameOfSubFolder + fileSeparator + nameOfJavaArchive;
    public String fullPathToJavaArchive = userDirectory + subFolderPathOfJavaArchive;
    public String nameOfClass = "MountainPrime";

    public void print()
    {
        System.out.println("--- Configuration");
        System.out.println("fileSeparator              : " + fileSeparator);
        System.out.println("userDirectory              : " + userDirectory);
        System.out.println("nameOfSubFolder            : " + nameOfSubFolder);
        System.out.println("nameOfJavaArchive          : " + nameOfJavaArchive);
        System.out.println("subFolderPathOfJavaArchive : " + subFolderPathOfJavaArchive);
        System.out.println("fullPathToJavaArchive      : " + fullPathToJavaArchive);
        System.out.println("nameOfClass                : " + nameOfClass);
        System.out.println();
    }
}
