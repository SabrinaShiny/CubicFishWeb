package classes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FreshWaterConstructor extends ObjectFactory{
	@Override
	public FreshWaterResident[] builder() {
		FreshWaterResident[] freshResident= null;

		try (Connection conn = DriverManager.getConnection(url,user,password)){
			Statement stmt = conn.createStatement();

			//get row count
			String query = "SELECT COUNT(*) AS anzahl FROM bewohnerdaten";
			ResultSet rSet = stmt.executeQuery(query);

			//move to first data row
			rSet.next();
			int rowCount = rSet.getInt("anzahl");

			//use rowCount for array
			freshResident = new FreshWaterResident[rowCount];

		//get resident data
			query = "SELECT * FROM bewohnerdaten";
			rSet = stmt.executeQuery(query);

		//set object data
			int i= 0;
			while (rSet.next()) {
				//builder
				FreshWaterResident newResident = new FreshWaterResident();
				newResident.setId(rSet.getInt("id"));
				newResident.setName(rSet.getString("bezeichnung"));
				newResident.setSName(rSet.getString("wissenschaftlicherName"));
				newResident.setOrigin(rSet.getString("herkunft"));
				newResident.setAge(rSet.getString("alterserwartung"));
				if (rSet.getString("info") != null) {
					newResident.setInfo(rSet.getString("info"));
				}
				newResident.setGroup(rSet.getString("fischgruppe"));

				//add object to array, so we can use id for reference
				freshResident[i] = newResident;
				i++;
			}

			//d = data
			int id;
			int dId;
			String dIdQuery;
			String wQuery;

			for (FreshWaterResident freshResident2 : freshResident) {
				//get id
				id = freshResident2.getId();

			//water data
				//get ww_id
				dIdQuery = "SELECT ww_id FROM bewohnerdaten WHERE id ="+ id;
				rSet = stmt.executeQuery(dIdQuery);

				//move to first row
				rSet.next();
				dId = rSet.getInt(1);

				//get data
				wQuery = "SELECT * FROM wasserwerte WHERE id ="+ dId;
				rSet = stmt.executeQuery(wQuery);

				//move to first row
				rSet.next();

				//set data
				freshResident2.setCMin(rSet.getDouble("temperaturvon"));
				freshResident2.setCMax(rSet.getDouble("temperaturbis"));
				freshResident2.setGhMin(rSet.getDouble("ghvon"));
				freshResident2.setGhMax(rSet.getDouble("ghbis"));
				freshResident2.setKhMin(rSet.getDouble("khvon"));
				freshResident2.setKhMax(rSet.getDouble("khbis"));
				freshResident2.setPhMin(rSet.getDouble("phvon"));
				freshResident2.setPhMax(rSet.getDouble("phbis"));

			//aquarium size
				//get bg_id
				dIdQuery = "SELECT bg_id FROM bewohnerdaten WHERE id ="+ id;
				rSet = stmt.executeQuery(dIdQuery);

				//move to first row
				rSet.next();
				dId = rSet.getInt(1);

				//get data
				wQuery = "SELECT * FROM beckengroese WHERE id ="+ dId;
				rSet = stmt.executeQuery(wQuery);

				//move to first row
				rSet.next();

				//add data
				freshResident2.setLiter(rSet.getInt("liter"));
				freshResident2.setAWidth(rSet.getInt("laenge"));
				freshResident2.setAHeight(rSet.getInt("hoehe"));
				freshResident2.setGroupSMin(rSet.getInt("gruppengrMin"));
				freshResident2.setGroupSMax(rSet.getInt("gruppengrMax"));

			//compatibility
				//get vg_id
				dIdQuery = "SELECT vg_id FROM bewohnerdaten WHERE id ="+ id;
				rSet = stmt.executeQuery(dIdQuery);

				//move to first row
				rSet.next();
				dId = rSet.getInt(1);

				//get data
				wQuery = "SELECT * FROM vergesellschaftung WHERE id ="+ dId;
				rSet = stmt.executeQuery(wQuery);

				//move to first row
				rSet.next();

				//add data
				freshResident2.setDiet(rSet.getString("erneahrung"));
				freshResident2.setDiet2(rSet.getString("erneahrung2"));
				freshResident2.setNature(rSet.getString("wesen"));
				freshResident2.setBehaviour(rSet.getString("verhalten"));
				freshResident2.setSizeMin(rSet.getDouble("grVon"));
				freshResident2.setSizeMax(rSet.getDouble("grBis"));
				freshResident2.setARegion(rSet.getString("beckenregion"));

			//BlackList
				//get data
				ArrayList<Integer> blackList= new ArrayList<>();
				wQuery = "SELECT bewohner1_id FROM blackList WHERE bewohner2_id ="+ id;
				rSet = stmt.executeQuery(wQuery);

				//move to first row
				while (rSet.next()) {
					blackList.add(rSet.getInt("bewohner1_id"));
				}
				//get data
				wQuery = "SELECT bewohner2_id FROM blackList WHERE bewohner1_id ="+ id;
				rSet = stmt.executeQuery(wQuery);

				//move to first row
				while (rSet.next()) {
					blackList.add(rSet.getInt("bewohner2_id"));
				}
				//add array
				freshResident2.setBlackList(blackList);
			}
			//close
			stmt.close();
			conn.close();
		}
		catch(SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return freshResident;
	}
}
