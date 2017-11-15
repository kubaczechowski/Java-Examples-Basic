/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicaldepartmentwithpersistance.util;

import graphicaldepartmentwithpersistance.DAL.filetypes.AbstractFile;
import graphicaldepartmentwithpersistance.DAL.filetypes.DepartmentPersistanceRandomTextFile;
import graphicaldepartmentwithpersistance.DAL.filetypes.NewIOTextFile;
import graphicaldepartmentwithpersistance.DAL.filetypes.SerializedFile;
import graphicaldepartmentwithpersistance.DAL.filetypes.TextFile;

/**
 *
 * @author jeppjleemoritzled
 */
public class FileTypeFactory {

    public enum FileType {
        TEXTFILE, RANDOM_BINARY, SERIALIZED, NIOTEXT
    }

    private static FileTypeFactory instance;

    private FileTypeFactory() {
    }

    // Singleton pattern
    public static FileTypeFactory getInstance() {
        if (instance == null) {
            instance = new FileTypeFactory();
        }
        return instance;
    }

    public AbstractFile create(FileType fileType, String fileName) throws DepartmentException {
        switch (fileType) {
            case TEXTFILE:
                return new TextFile(fileName);
            case RANDOM_BINARY:
                return new DepartmentPersistanceRandomTextFile(fileName);
            case SERIALIZED:
                return new SerializedFile(fileName);
            case NIOTEXT:
                return new NewIOTextFile(fileName);
            default:
                throw new DepartmentException("No such filetype implemented");
        }
    }
}
