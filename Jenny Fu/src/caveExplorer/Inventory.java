package caveExplorer;

public class Inventory {
	
	private String map;

	public Inventory() {
		updateMap();
	}

	public void updateMap() {
		map = " ";
		//create line across top
		for(int i = 0; i < CaveExplorer.caves[0].length - 1; i++) {
			map += "____"; //4 underscores
		}
		map += "___\n"; //3 underscores
		for(CaveRoom[] row : CaveExplorer.caves) {
			//3 rows of text
			for(int i = 0; i < 3; i++) {
				String text = "";
				for(CaveRoom cr : row) {
					//if door is open, leave open
					if(cr.getDoor(CaveRoom.WEST) != null && cr.getDoor(CaveRoom.WEST).isOpen()) {
						text += " ";
					} else {
						text += "|";
					}
					if(i == 0) {
						text += "   "; //3 spaces
					}else if(i == 1) {
						text += " " + cr.getContents() + " ";
					}else if(i == 2) {
						if(cr.getDoor(CaveRoom.SOUTH) != null && cr.getDoor(CaveRoom.SOUTH).isOpen()) {
							text += "   ";
						} else {
							text += "___";
						}
					}
				} //last cave room in row
			text += "|";
			map += text + "\n";
			}
		}
	}

	public String getDescription() {
		//return "You have nothing in your inventory.";
		return map;
	}

}
