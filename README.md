# My Brews
This is a website for tracking the beers that I brew for the office and at home. This project is also to learn some new technologies.

## Technologies Used
##### Front End
- [SASS][1]
- React
- Various other libs

##### Back End / Building
- Java 8 and JEE 7.0
- Maven

## Project Requirements
- [WildFly][5]
- A Postgres DB
- Ruby (For SASS)

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

##### Installing SASS
#### Windows
Navigate to http://rubyinstaller.org/ and choose your correct download. This is to install Ruby with the rubygems. Once 

##### Windows and Linux
Once you have ruby and rubygems, verify that they are in your path with `ruby -v` and `gem -v`. If they are in your path, you can install sass with

```bash
gem install sass
```

> Linux might require **sudo**.

## Building, Deploying, and Running
##### Adding The Datasource and Postgresql Connector to Wildfly
Start up your wildfly node and run

```bash
mvn install
```

Will add the `postgresql.jar` to your wildfly server and add the **MyBrewsDS** data source. 

##### Launching the WebServices
To build and deploy the application, run

```bash
mvn wildfly:deploy
```

##### Launching the Front End App
The front end app requires `npm` and `gulp` to be built and manage dependencies.

> Currently, the front end app is only set for development and is running off of browsersync

To install any dependencies, run `npm install`. If new scss depdendencies have been added or this is your first time cloning, run `npm run symlinks` which will create the symlinks in the `src/main/app/scss/vendors` directory. You can view the README.md there as well. (Creating the symlinks will require Admin for Windows).

To install gulp, run `npm install -g gulp`.

Once your dependencies have been set up and gulp has been isntalled, you can launch the front end app with

```bash
gulp
```

Super simple! It will distribute all the files in a `dist` folder and open up your browser to `localhost:3000` and you can view the app.

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
HTTP/1.1 201 Created
Connection: keep-alive
X-Powered-By: Undertow/1
Server: WildFly/8
Location: /api/yeasts/1
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

## Documentation and Dependencies
If you are interested in viewing the javadoc that is a part of this project and viewing all the dependencies, you can run
```bash
mvn site
```
which will generate a maven site with all dependencies and generated javadoc in  your `/target/site` folder which you can then open and view in a browser.


[1]: http://sass-lang.com/
[2]: http://compass-style.org
[3]: http://fortawesome.github.io/Font-Awesome/icons/
[5]: http://wildfly.org/downloads/
[6]: https://gist.github.com/luislavena/f064211759ee0f806c88
