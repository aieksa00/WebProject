package services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Beans.Address;
import Beans.Location;
import Beans.SportsObject;

public class SportsObjectService {
	
	private HashMap<String,SportsObject> sportsobjects = new HashMap<String, SportsObject>();
	
    public SportsObjectService(){
        BufferedReader in = null;
		try {
			File file = new File("static\\sportsobjects.txt");
			System.out.println(file.getCanonicalPath());
			in = new BufferedReader(new FileReader(file));
			readSportsObjects(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if ( in != null ) {
				try {
					in.close();
				}
				catch (Exception e) { }
			}
		}
    }


    private void readSportsObjects(BufferedReader in) {
		String line, id="" ,name = "", objectType = "", description = "", status = "", location = "", rating = "", workingHours="";
		StringTokenizer st;
		try {
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.indexOf('#') == 0)
					continue;
				st = new StringTokenizer(line, ";");
				while (st.hasMoreTokens()) {
					id = st.nextToken().trim();
				    name = st.nextToken().trim();
					objectType = st.nextToken().trim();
					description = st.nextToken().trim();
                    status = st.nextToken().trim();
                    location = st.nextToken().trim();
                    rating = st.nextToken().trim();
                    workingHours = st.nextToken().trim();
				}
				SportsObject sportsObject = new SportsObject(name,objectType,description,Boolean.parseBoolean(status),StringToLocation(location),Double.parseDouble(rating),workingHours);
				sportsobjects.put(id, sportsObject);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

    private Location StringToLocation(String s){
        String[] parts = s.split(",");
        Address a = new Address(parts[2],parts[3],parts[4],parts[5]);
        Location l = new Location(Double.parseDouble(parts[0]),Double.parseDouble(parts[1]),a);
        return l;
    }

    public void writeSportsObjects()
    {		
		List<String[]> dataLines = new ArrayList<>();
		for(SportsObject user: sportsobjects.values())
			dataLines.add(user.toCSV());
		File csvOutputFile = new File("static\\sportsobjects.txt");
		try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
			dataLines.stream().map(this::convertToCSV).forEach(pw::println);
		}
		catch(Exception e){}
    }

	public String convertToCSV(String[] data) {
		return Stream.of(data).collect(Collectors.joining(";"));
	}

    public Collection<SportsObject> getSportsObjects() {
		return sportsobjects.values();
	}

	public SportsObject getSportsObject(String id) {
		return sportsobjects.get(id);
	}

	public void addSportsObject(SportsObject sportsObject) {
		Integer maxId = -1;
		for (String id : sportsobjects.keySet()) {
			int idNum =Integer.parseInt(id);
			if (idNum > maxId) {
				maxId = idNum;
			}
		}
		maxId++;
		this.sportsobjects.put(maxId.toString(), sportsObject);
		writeSportsObjects();
	}

	public void editSportsObject(String id, SportsObject sportsObject) {
		this.sportsobjects.put(id, sportsObject);
	}

	public void deleteSportsObject(String id) {
		this.sportsobjects.remove(id);
	}

}

