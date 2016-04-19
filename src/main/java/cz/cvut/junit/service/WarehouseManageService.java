package cz.cvut.junit.service;

public interface WarehouseManageService {

	/** 1) Zji�t�n� um�st�n� polo�ky
	 * 
	 * kde se nach�z� maso po�adovan�ho typu a typu uskladn�n�
	 * 
	 * @param { "type" : "CHUCKER", "cooling-type" : "FREEZING" }
	 * @return { "item-place" : [
	 *  	{"box-number" : "41", "shelf-number" : "k23", "count" : 102, "date-of-expiration" : "23.07.2016" },
	 *  	{"box-number" : "49", "shelf-number" : "e6", "count" : 44, "date-of-expiration" : "28.09.2016" }
	 *   ] }
	 */
	public String getLocationOfItemInWarehouse(String inputJson);

	
	/** 2) Vyskladn�n� dle druhu masa
	 * 
	 * vyskladnuje maso ze skladu, jen� jde k z�kazn�kovy. Tedy polo�ka p�est�v� existovat ve skladu.
	 * Skladn�k zad� druh masa, typ uskladn�n� a mno�stv� v jednotk�ch. 
	 * Nepovinn� zad�n� po�et dn�, jak dlouho m� maso je�t� alespo� vydr�et
	 * 
	 * @param {"type" : "CHICKEN", "count" : 8, "cooling-type" : "COOLING", "days-durability": 7 }

	 * @return { "item-place" : [
	 * 		{ "box-number" : "15", "shelf-number" : "m5", "count" : 2, "date-of-expiration" : "10.07.2016" },
	 * 		{ "box-number" : "54", "shelf-number" : "d2", "count" : 6, "date-of-expiration" : "30.06.2016" }
	 * 	] }
	 */
	public String getPickingItemFromWarehouseByMeatType(String inputJson);
	
	/** 3) P��prava a odesl�n� z�silky
	 * 
	 * vyskladneni vice polozek najednou
	 * 
	 * @param {"meat-order" : [ 
	 * 		{ "type" : "OPOSSUM", "count" : 126, "cooling-type" : "FREEZING", "days-durabilit" : 14 },
	 * 		{ "type" : "ALLIGATOR", "count" : 75, "cooling-type" : "FREEZING", "days-durabilit" : 14 },
	 * 		{ "type" : "SWEETBREADS", "count" : 132, "cooling-type" : "COOLING"} 
	 *  ] }
	 *  
	 * @return  { "meat-order-place" : [ 
	 * 		{ "box-number" : "64", "shelf-number" : "b19", "type" : "OPOSSUM", "count" : 126, "date-of-expiration" : "12.08.2016" },
	 * 		{ "box-number" : "77", "shelf-number" : "n10", "type" : "ALLIGATOR", "count" : 25, "date-of-expiration" : "20.10.2016" },
	 * 		{ "box-number" : "82", "shelf-number" : "x15", "type" : "ALLIGATOR", "count" : 50, "date-of-expiration" : "20.10.2016" },
	 * 		{ "box-number" : "12", "shelf-number" : "l23", "type" : "SWEETBREADS", "count" : 132, "date-of-expiration" : "26.04.2016" }
	 * 	] }
	 * 
	 */
	public String preparationShipmentOfMeat(String inputJson);

	/** 4) P��prava a odesl�n� z�silky
	 * 	
	 * Skladn�k m� v ruce p�epravku s masem a chce ji um�stit do skladu.
	 * Aplikace nalezne voln� m�sto a vr�t� um�st�n�, kam maso za�adil.

	 * @param { "type" : "PORK", "count" : 84, "date-of-slaughter" : "25.02.2016", "is-frozen" : false }
	 * @return { "item-place" : [ 
	 * 		{ "box-number" : "92","shelf-number" : "f6","count" : 84 }
	 * 	] }
	 * 
	 */
	public String putItemInStock(String inputJson);
	
	/** 5) P�ijmut� z�silky - nepovinn�
	 * 
	 * P�ed skladem stoj� dod�vka pln� masa a skladn�k chce naskladnit v�echny polo�ky najednou.
	 * 
	 * @param { "meat-item" : [ 
	 * 		{ "type" : "PUFFIN", "count" : 90, "date-of-slaughter" : "22.01.2016", "is-frozen" : false },
	 * 		{ "type" : "CRAB", "count" : 12, "date-of-slaughter" : "19.01.2016", "is-frozen" : false }
	 *  ] }
	 * @return { "item-place" : [ 
	 *  	{ "type" : "PUFFIN", "box-number" : "58", "shelf-number" : "h5", "count" : 90 },
	 *  	{ "type" : "CRAB", "box-number" : "75", "shelf-number" : "m27", "count" : 1 },
	 *  	{ "type" : "CRAB", "box-number" : "81", "shelf-number" : "y9", "count" : 11 }
	 *   ] }

	 */
	public String receivingShipments(String inputJson);
		
	/** 7) Generov�n� report� o aktu�ln�m stavu
	 * 
	 * �iditel chce sem tam v�d�l aktu�ln� stav skladu, 
	 * aby v�d�l co mu doch�z� a m� z�skat od dodavatel� 
	 * nebo naopak co u� nem� br�t.
	 * 
	 * @return cvs
	 * V reportu bude ve form�tu csv a pro ka�d� maso: 
	 * 	druh masa, 
	 * 	kolik p�epravek, 
	 *  kdy kon�� trvanlivost,
	 *  je-�i mra�en�
	 * 
	 */
	public byte[] generateReportOnCurrentState();
	
	/** 8) Vyhozen� polo�ek
	 * 	
	 * Jde o vyhozen� pro�l�ho masa ze skladu. 
	 * Skladn�k dostane seznam v�ech polo�ek s jejich um�st�n�m, 
	 * kter� jsou k dne�n�mu datu pro�l� a polo�ky p�estanou existovat ve skladu.
	 * 
	 * @return { "item-place" : [ 
	 * 		{ "box-number" : "39", "shelf-number" : "g24", "count" : 42  }, 
	 * 		{ "box-number" : "78", "shelf-number" : "g1", "count" : 84  },
	 * 		{ "box-number" : "71", "shelf-number" : "d13", "count" : 66  },	
	 * 		{ "box-number" : "31", "shelf-number" : "p6", "count" : 142 }
	 * 	] }
	 * 
	 */
	public String ejectionItems();

	/** 9) P�eskladn�n� polo�ky
	 * 
	 * Skladn�k zad� typ masa, datum expirace a mno�stv�, jeho sou�asn� um�st�n� a budouc� um�st�n�. 
	 * Syst�m bude pova�ovat polo�ku za p�esunutou na nov� um�st�n�.
	 * 
	 * @param { 
	 * 		"type" : "SWEETBREADS", "count" : 27,  "date-of-expiration" : "27.05.2016",
	 * 		"current-item-place" : { "box-number" : "11","shelf-number" : "p28"},
	 * 		"new-item-place" : { "box-number" : "30", "shelf-number" : "a12" }
	 * 	}

	 */
	public void moveItem(String inputJson);
	
	/** 10) Vypr�zdn�n� m�stnosti pro vy�ist�n�
	 * 
	 * Sem tam je pot�eba vy�istit nebo opravit m�stnost pro skladovan�. 
	 * Proto je nutn� v�echny polo�ky v m�stnosti p�esunout do jin�ch m�stnost�.
	 * Skladn�k zad� ��slo m�stnosti
	 * Syst�m vr�t� seznam v�ech polo�ek v m�stnosti:
	 * 		typ masa, datum expirace a mno�stv�, jeho sou�asn� um�st�n� a budouc� um�st�n� 
	 * Syst�m bude nad�le pova�ovat polo�ky za p�esunut�.
	 * 
	 * @param { "boxNumber" : "10" }
	 */
	public void emptyCoolingBoxForCleaning(String inputJson);
	
}
