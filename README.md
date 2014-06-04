givemywish
==========

Repository for Project Wish

To Run the Application:
- Sun JDK 7 should be present on the system, 
- Download Eclipse EE (kepler or above, supporting JDK 7) from eclipse site - https://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/keplersr2
- Setup tomcat 7 and above as server runtime for eclipse.
- Setup mysql server (5.1 or above), keep user and pwd as root if possible and start it.
- Database script is present in Git under sqlschema folder. Import 'wish' database to mysql instance from sqlschema/wish.sql
- Clone the project from git.
- Import project as existing maven project, choose pom.xml under giftweb directory
- Build the project using maven clean install command.
- Right click on tomcat server view in eclipse and add giftweb project.
- Right click on 'giftweb' project, under properties -> deployment assembly, add Java Build Path Entries (implies Maven Dependencies)
- STart the tomcat server
- once server starts, load this url - http://localhost:8080/giftweb/home
