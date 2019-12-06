package com.paramesh.pojo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Readline {
	
	public void fileWalk() {
		try (Stream<Path> walk = Files.walk(Paths.get(""))) {

			List<String> result = walk.filter(Files::isRegularFile)
					.map(x -> x.toString()).collect(Collectors.toList());

			Iterator it = result.iterator();
			while(it.hasNext()){
				String file = (String) it.next();
				if(file.endsWith(".java")){
					System.out.println(file);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void listFiles() throws IOException {
		String path = "D:/Learnings/Practice_Workspace_Java_1/HibernateApps/src/com/paramesh/mapping/collection";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		BufferedReader br = null;
		String sCurrentLine;
		Map map = new HashMap();
		for (File file : listOfFiles) {
			int eof = 0;
			if (file.isFile()) {
				// System.out.println(file.getName());
				br = new BufferedReader(new FileReader(path + "/" + file.getName()));
				while ((sCurrentLine = br.readLine()) != null) {
					eof++;
					// System.out.println(sCurrentLine);
				}
				map.put(file.getName(), eof);
			}
		}
		System.out.println("== " + map);

	}
	public static void main(String[] args) throws IOException {
		Readline readline = new Readline();
		//readline.listFiles();
		readline.fileWalk();
		
		/*String path = "D:\\Learnings\\Practice_Workspace_Java_1\\HibernateApps\\src\\com\\paramesh\\GeneratorAlgorithems\\GeneratorAlgorithemsTest.java";
		String text = "";
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(33);
		al.add(41);
		al.add(43);
		al.add(52);
		al.add(60);
		al.add(62);
		al.add(70);
		al.add(78);
		al.add(80);
		al.add(87);
		al.add(88);
		al.add(89);
		int lineNumber;
		try {
			FileReader readfile = new FileReader(path);
			BufferedReader readbuffer = new BufferedReader(readfile);
			for (lineNumber = 1; lineNumber < 90; lineNumber++) {
				if (al.contains(lineNumber)) {
					text = readbuffer.readLine();
					text.trim();
				} else
					readbuffer.readLine();
				if (!text.contains("System.out.println")) {
					System.out.println(text);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileReader readfile = new FileReader(path);
			BufferedReader readbuffer = new BufferedReader(readfile);
			for (lineNumber = 1; lineNumber < 95; lineNumber++) {
				
				text = readbuffer.readLine();
				if (text.contains("\"") || text.contains("char ")|| text.contains("float ") || text.contains("double ") || text.contains("long ")) {
					System.out.println(text);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println(al);*/
	}
}