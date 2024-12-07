/*File
Although most of the classes defined by java.io operate on streams, the File class does
not. It deals directly with files and the file system. That is, the File class does not specify how
information is retrieved from or stored in files; it describes the properties of a file itself. A
File object is used to obtain or manipulate the information associated with a disk file, such as
the permissions, time, date, and directory path, and to navigate subdirectory hierarchies. Files
are a primary source and destination for data within many programs. Although there are
severe restrictions on their use within applets for security reasons, files are still a central
resource for storing persistent and shared information. A directory in Java is treated simply as
a File with one additional property—a list of filenames that can be examined by
the list( ) method.
The following constructors can be used to create File objects:
File(String directoryPath)
File(String directoryPath, String filename)
File(File dirObj, String filename)
File(URI uriObj)
Java’s stream-based I/O is built upon four abstract classes: InputStream, OutputStream,
Reader, and Writer. These classes were briefly discussed in Chapter 13. They are used to
create several concrete stream subclasses. Although your programs perform their I/O
operations through concrete subclasses, the top-level classes define the basic functionality
common to all stream classes.
InputStream and OutputStream are designed for byte streams. Reader and Writer are
designed for character streams. The byte stream classes and the character stream classes form
separate hierarchies. In general, you should use the character stream classes when working
with characters or strings, and use the byte stream classes when working with bytes or other
binary objects.*/
// Demonstrate File.
import java.io.File;
class FileDemo {
static void p(String s) {
System.out.println(s);
}
public static void main(String args[]) {
File f1 = new File("/java/COPYRIGHT");
p("File Name: " + f1.getName());
p("Path: " + f1.getPath());
p("Abs Path: " + f1.getAbsolutePath());
p("Parent: " + f1.getParent());
p(f1.exists() ? "exists" : "does not exist");
p(f1.canWrite() ? "is writeable" : "is not writeable");
p(f1.canRead() ? "is readable" : "is not readable");
30
p("is " + (f1.isDirectory() ? "" : "not" + " a directory"));
p(f1.isFile() ? "is normal file" : "might be a named pipe");
p(f1.isAbsolute() ? "is absolute" : "is not absolute");
p("File last modified: " + f1.lastModified());
p("File size: " + f1.length() + " Bytes");
}
}
File Name: COPYRIGHT
Path: /java/COPYRIGHT
Abs Path: /java/COPYRIGHT
Parent: /java
exists
is writeable
is readable
is not a directory
is normal file
is absolute
File last modified: 812465204000
File size: 695 Bytes