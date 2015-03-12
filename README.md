# My Brews
This is a website for tracking the beers that I brew for the office and at home. This project is also to learn some new technologies.

## Technologies Used
##### Front End
- [SASS][1] with [Compass][2]
- AngularJS
- [Font Awesome Icons][3]
- jQuery (Should get replaced by angular)
- [moment.js][4]

##### Back End / Building
- Java 8 and JEE 7.0
- Maven

## Project Requirements
- [WildFly][5]
- A Postgres DB
- Ruby (For SASS and Compass)

```
  Database Server   = localhost
  Database Name     = mybrews
  Database Password = welcome1
  Database Username = mybrews
```
These can be changed in the `pom.xml`

##### Installing Posgres
If you do not have postgresql, here are the steps for setup/install on linux.
```bash
sudo apt-get install -y postgresql-client postgresql postgresql-contrib pgadmin3
```
> **pgadmin3** is *optional*. It is the GUI tool.

Once it is installed, you can connect with:
```bash
sudo -u {db-user} psql {db-name}
```
> I usually create a new linux user for each user in the database. Probably not required.. Just can't figure out out otherwise. The command (in Ubuntu) is
```bash
sudo useradd {username}
```

To create the database and user for the default configuration in the `pom.xml`
```bash
sudo -u postgres createuser -D -A -P mybrews
sudo -u postgres createdb -O mybrews mybrews
sudo -u mybrews psql -d mybrews -a -f src/main/scripts/tables.sql
```
> This will use the **postgres** admin user to create a new user **mybrews** that only has privileges over the new database **mybrews**. The first command will also prompt for you to enter a password. The third command will run the **tables.sql** database script as the **mybrews** user in the new **mybrews** db.

##### Installing SASS and Compass
#### Windows
This part is kind of a pain.. The rubygems SSL certificate has expired.. So the following steps need to be done laid out in this post on [SSL upgrades on rubygems.org and RubyInstaller versions][6] in github.

##### Windows And Linux
Once you have Ruby and the rubygems fixed, you can install sass and compass with the following command
```bash
gem install sass compass
```
> Linux might require **sudo**.

## Building, Deploying, and Running
##### Compiling SASS
Navigate to the project home directory and run
```bash
compass compile
```
This will generate all the SCSS files into css files in the following folder: `src/main/webapp/resources/css`.

If you are doing a bunch of css changes, `compass watch` in the project home directory will automatically auto-compile the css files when a `.scss` files is modified. Neat stuff. The current compass configuration shows the line numbers of how the file got generated and does not minify the css. View `config.rb` for the compass settings.

##### Adding The Datasource and Postgresql Connector to Wildfly
Start up your wildfly node and run
```bash
mvn install
```
Will add the `postgresql.jar` to your wildfly server and add the **MyBrewsDS** data source. To build and deploy the application, run
```bash
mvn wildfly:deploy
```
when your server is running. Once it has been deployed, you can navigate to **localhost:8080/my-brews** to view the magic.

## Documentation and Dependencies
If you are interested in viewing the javadoc that is a part of this project and viewing all the dependencies, you can run
```bash
mvn site
```
which will generate a maven site with all dependencies and generated javadoc in  your `/target/site` folder which you can then open and view in a browser.

## Web Services

Resource used for planning RESTful web services: http://www.restapitutorial.com/lessons/httpmethods.html

### CRUD
This application is pretty much just create, retrieve, update, and ~~delete~~.
> Well.. now that I think about it, probably not too much delete.
To keep consistent, I created an interface for each method so they will all have the same path when fully implemented.

> Any time there is an **{entityName}**, it is a pluralized version.

##### Retrieving Data
Any entity will be retrieved just by sending a `GET` request to **/api/_{entityName}_/{id}**. An HTTPResponse will be returned with the entity (if found). If the entity is not found, Status Code **404** *(Not Found)* will be returned, otherwise **202** *(OK)* with the entity as json.

To retrieve all of a single entity, send a `GET` request to **/api/_{entityName}_**.

Some example curl calls:
```bash
curl -iX GET localhost:8080/my-brews/api/beers
curl -iX GET localhost:8080/my-brews/api/beers/1
```

The first call will retrieve all beers and the second call will attempt to find beer with id 1. Since there currently is no data for beer, try these curl requests (constants).
```bash
curl -iX GET localhost:8080/my-brews/api/beerstyles
curl -iX GET localhost:8080/my-brews/api/beercolors/1
```
The first call will retrieve all beer styles and the other call will return the beer color with id 1.

#### Creating Data
Any entity can be created by sending a `POST` request to **/api/_{entityName}_**.

An example curl call:
```bash
curl -H "Content-Type: application/json" \
     -d '{"name": "Wyeast #1332 Northwest Ale Yeast", "type": "LIQUID"}' \
     -i localhost:8080/my-brews/api/yeasts
```
This will create a new yeast with the name and given Yeast Type. This will return a status of 201 *(Created)* if successful along with a *Location* header with a link to the new resource. A successful create would return something like this:
```bash
**HTTP/1.1 201 Created**
Connection: keep-alive
X-Powered-By: Undertow/1
Server: WildFly/8
**Location: /api/yeasts/1**
Content-Length: 0
Date: Thu, 12 Mar 2015 00:19:51 GMT
```

#### Updating Data
An entity can be updated by sending a `PUT` request to **/api/_{entityName}_**
> This might get updated later to pass in the id as well.. ex: **/api/_{entityName}_/_{id}_**. I'm not sure what I like yet.

An example update of the yeast we just created:
```bash
curl -H "Content-Type: application/json" \
     -X PUT -d '{"id": "1", "name": "Wyeast #1332 Northwest Ale Yeast", "type": "DRY"}' \
     -i localhost:8080/my-brews/api/yeasts
```
This updates the yeast we just created to have a DRY yeast type. Super exciting!

#### Deleting Data
An entity can be deleted by sending a <code>DELETE</code> request to **/api/_{entityName}_/_{id}_**. So lets delete that yeast we just created:
```bash
curl -iX DELETE localhost:8080/my-brews/api/yeasts/1
```
Wala! [Magic!](http://i.imgur.com/t9P566O.jpg])

[1]: http://sass-lang.com/
[2]: http://compass-style.org
[3]: http://fortawesome.github.io/Font-Awesome/icons/
[4]: http://momentjs.com/
[5]: http://wildfly.org/downloads/
[6]: https://gist.github.com/luislavena/f064211759ee0f806c88
