import java.io.File;

public class FindFileAlgorithm {
	
	// reports all entries of the file system rooted at the given path having the given file name
	public static void find(String filePath, String fileName) {
		try {
			File rootPath = new File(filePath);
			File[] fileList = rootPath.listFiles();
			
			if (fileList == null) {
				// no files found exit
				return;
			}
			
			for (File fileItem : fileList) {
	            if (fileItem.isDirectory()) {
	            	// go inside the sub directory
	            	find( fileItem.getAbsolutePath(), fileName );
	                // System.out.println("Directory: " + fileItem.getAbsoluteFile());
	            }
	            else {
	            	// we only got a file; check the file name
	            	String fileItemName = fileItem.getName();
	            	if (fileItemName.equals(fileName)) {
	            		System.out.println("File: " + fileItem.getAbsoluteFile());
	            	}
	            }
	        }
			
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (SecurityException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		String filePath = "C:\\\\Users\\\\Asus\\\\Desktop\\\\Summer 2021\\\\COMP-229 Web Application Development";
		String fileName = "package-lock.json";
		System.out.println("Look for file named: " + fileName + " in " + filePath);
		find(filePath, fileName);
	}
}
