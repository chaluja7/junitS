package cz.cvut.junit.service;

public interface WarehouseConfigurationService {

	/**
	 * Na�ten� init JSON s informacemi o firm� a dispozic�ch skladu a nastav�
	 * syst�mov� datum na 19.04.2016
	 * 
	 * @param init.json
	 */
	public void initializateWarehouse(String inputJson);

	/**
	 * Posunut� syst�mov�ho data o jeden den.
	 * 
	 */
	public void shiftWarehouseSystemDate();

}
