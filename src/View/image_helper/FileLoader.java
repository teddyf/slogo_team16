package View.image_helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * A helpful facade class for the filechooser javafx object. 
 * Construct with the nested enum to pick files with the relevant extension.
 * Currently opens up a new stage outside of the current javafx stage
 * <p>
 * Default Starting directory is Java Root folder
 * 
 * @see FileChooser
 * @see FileExtension
 * @author George Bernard
 */
public class FileLoader {

	private static final String TITLE = "Load File";
	private static final String ERR_MSG = "File Failed To Load";
	private static final StartDirectory DEFAULT_START = StartDirectory.SOURCE_DIRECTORY;

	/**
	 * Starting Directories for FileLoader 
	 * 
	 * @author George Bernard
	 */
	public enum StartDirectory{
		/**
		 * Platform agnostic user home directory
		 */
		HOME_DIRECTORY(System.getProperties().getProperty("user.dir")),
		/**
		 * Java Root directory
		 */
		SOURCE_DIRECTORY("./");

		private String myPath;

		private StartDirectory(String aPath){
			myPath = aPath;
		}

		/**
		 * @return path to directory
		 */
		public String getPath(){
			return myPath;
		}
	}		
	private FileChooser myFileChooser;

	/**
	 * Constructed with no arguments, the loader will simply use all files.
	 */
	private FileLoader(StartDirectory aStart) {
		myFileChooser = new FileChooser();
		myFileChooser.setTitle(TITLE);
		myFileChooser.setInitialDirectory(new File(aStart.getPath()));
	}

	public FileLoader() {
		this(DEFAULT_START);
	}

	/**
	 * Returns the file chosen after the file chooser is completed 
	 * 
	 * @see File
	 * @return the file chosen after choosing file 
	 */
	public File loadSingle() throws FileNotFoundException {
		File loadedFile = myFileChooser.showOpenDialog(makeStage());

		if(loadedFile == null) {
			throw new FileNotFoundException(ERR_MSG);
		}

		return loadedFile;
	}

	private Stage makeStage() {
		return new Stage();
	}
	
}
