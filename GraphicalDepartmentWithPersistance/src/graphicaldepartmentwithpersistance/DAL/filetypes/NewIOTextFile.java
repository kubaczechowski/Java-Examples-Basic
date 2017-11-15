/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicaldepartmentwithpersistance.DAL.filetypes;

import graphicaldepartmentwithpersistance.BE.Department;
import java.io.IOException;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author jeppjleemoritzled
 */
public class NewIOTextFile extends AbstractFile {

    private final Path path = Paths.get(fileName);

    public NewIOTextFile(String fileName) {
        super(fileName + ".niotxt");
    }

    @Override
    public void addDepartment(Department d) throws IOException {
        String deptString = departmentToString(d);
        Files.write(path, deptString.getBytes(), APPEND);
    }

    @Override
    public void deleteById(int departmentId) throws IOException {
        Files.readAllLines(path);
        List<String> result = Files.lines(path)
                .filter(line -> {
                    Department dept = stringToDepartment(line);
                    return dept.getId() != departmentId;
                })
                .collect(Collectors.toList());
        Files.write(path, result, TRUNCATE_EXISTING);
    }

    @Override
    public Department getById(int departmentId) throws IOException {
        final String deptString;

        Optional<String> result = Files.lines(path)
                .filter(line -> {
                    Department dept = stringToDepartment(line);
                    return dept.getId() == departmentId;
                }).findFirst();
        return stringToDepartment(result.get());
    }

    @Override
    public List<Department> getAll() throws IOException {
        List<Department> depList = new ArrayList();

        Files.lines(path).forEach(line -> {
            depList.add(stringToDepartment(line));
        });

        return depList;
    }

    // This adds extra protection against data loss
    // as it writes a temp file first, and then
    // overwrites the original before deleting
    // the temp file.
    @Override
    public void saveAll(List<Department> depts) throws IOException {
        Path tempPath = Paths.get(fileName + "_TEMP");
        Files.createFile(tempPath);

        for (Department dept : depts) {
            String deptString = departmentToString(dept);
            Files.write(tempPath, deptString.getBytes(), APPEND);
        }

        // Safe, ensures all of file is written before deletion
        Files.copy(tempPath, path,
                StandardCopyOption.REPLACE_EXISTING);
        Files.deleteIfExists(tempPath);
    }

    private Department stringToDepartment(String deptString) {
        String[] fields = deptString.split(",");
        return new Department(
                Integer.parseInt(fields[0].trim()),
                fields[1].trim()
        );
    }

    private String departmentToString(Department dept) {
        return dept.getId() + ","
                + dept.getName() + "\n";
    }

}
