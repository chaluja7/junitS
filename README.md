# JUNIT competition #

## Databáze PostgreSQL ##
* Stáhněte a nainstalujte si databázi PostgreSQL
 * Odkaz na stažení: http://www.postgresql.org/download/
 * Instalační manuál: http://postgres.cz/wiki/Instalace_PostgreSQL
 * Defaultně bude vytvořen user "postgres" s heslem "postgres". Samozřejmě můžeme vytvořit libovolného usera.
* Stáhněte a nainstalujte si aplikaci pgAdmin.
 * Odkaz na stažení: http://www.pgadmin.org/download/
* V aplikaci pgAdmin vytvořte na svém lokálním databázovém (PostgreSQL) serveru databázi "junitS".

    ``CREATE DATABASE junitS WITH OWNER = postgres ENCODING = 'UTF8' TABLESPACE = pg_default LC_COLLATE = 'cs_CZ.UTF-8' LC_CTYPE = 'cs_CZ.UTF-8' CONNECTION LIMIT = -1;``

    V případě využití jiného usera samozřejmě změníme hodnotu OWNER.
    
## Build ##
* Aplikaci zbuildíte příkazem 

    ``mvn clean install``
    
 * Po provedení se automaticky vytvoří tabulka 'persons' a měla by se naplnit ukázkovými daty
    
## Deploy ##
* Stáhněte a někam si rozbalte Tomcat (já mám verzi 7.0.57, ale bude to fungovat i na nejnovější)
 * Odkaz na stažení: http://tomcat.apache.org/
* V IDEE Run/Debug configuration -> Add new configuration -> Tomcat server local -> Vyberte cestu k rozbalenému serveru -> V deployment pak přidejte nový deploy junitS:war
 * Po dokončení těchto kroků můžete spustit server v debug módu normálně broučkem. Po většině provedených změn není nutné server restartovat, ale stačí Update
    
## API ##
* Po spuštění serveru by standardně na adrese localhost:8080 měly běžet resourcy
 * /api/v1/persons/all
 * /api/v1/person/{personId}

  