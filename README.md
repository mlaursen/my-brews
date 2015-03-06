<h2>My Brews</h2>
<p>This is a website for tracking the beers that I brew for the office and at home. This project is also to learn some new technologies.

<h3>Technologies Used</h3>
<h5>Front End</h5>
<ul>
<li>SASS with <a href="http://compass-style.org">Compass</a>- <a href="http://sass-lang.com/">Syntactically Awesome Style Sheets</a>
<li>AngularJS
<li>FontAwesome - <a href="http://fortawesome.github.io/Font-Awesome/icons/">Neat Font Library</a>
<li>jQuery
<li>moment.js - <a href="http://momentjs.com/">Javascript Library for Date manipulation</a>
</ul>

<h5>Back End / Building</h5>
<ul>
<li>Java 8 and J2EE 7.0
<li>Maven
</ul>

<h3>Project Requirements</h3>
<p>All that is required to run this project is a wildfly server (preferably 8.2.0), a running postgres database, ruby, sass and compass installed. The default database configuration is:
<pre>
  Database Server   = localhost
  Database Name     = mybrews
  Database Password = welcome1
  Database Username = mybrews
</pre>
<p>These can be changed in the <code>pom.xml</code>
<h4>Install SASS and Compass on Windows</h4>
<p>This part is kind of a pain.. The rubygems SSL certificate has expired.. So a fix needs to be done.
<a href="https://gist.github.com/luislavena/f064211759ee0f806c88">SSL upgrades on rubygems.org and RubyInstaller versions</a>
<p>Once you have Ruby and the rubygems fixed, you can install sass and compass with the following command:<pre>
gem install sass compass
</pre> (Linux might require <code>sudo</code>).

<p>Finally, compile the css files with<pre>
compass compile
</pre>
in the my-brews home directory. The command will generate the files into <code>src/main/webapp/resources/css</code>. If you are doing a lot of css changes in sass, run the following command in the my-brews home directory:<pre>
compass watch
</pre>
This will auto-compile any changes to <code>.scss</code> files any time one gets modified. Neat stuff! The current compass configuration shows the line numbers of how the file got generated and does not minify the css. View <code>config.rb</code> for the compass settings.


<h3>Running / Deploying</h3>
<p>For first time deployment, run:<pre>
<code>mvn install wildfly:deploy</code>
</pre>
<p>The <code>install</code> will add a <code>postgresql.jar</code> and add the <code>my-brews</code> xa-datasource to your wildfly deployment. For all following deployments, a simple <code>mvn wildfly:deploy</code> will suffice.

<p>Once the app has been deployed, you can navigate to <a href="http://localhost:8080/my-brews">localhost:8080/my-brews</a> to view it.

<h3>Viewing Javadoc / Dependencies / Other stuffs</h3>
<p>To view all javadoc and other maven information, run <pre>
mvn site
</pre>
<p>This will generate the maven site with javadoc and other information in your <code>/target/site</code> folder.

<h3>Web Services</h3>
<p>Currently, all the web services have a consistent pattern because they were declared using interfaces.
<h4>Retrieving Data</h4>
<p>Any entity will be retrieved just by sending a <code>GET</code> request to <code>/api/{entityName}/{id}</code>. An HTTPResponse will be returned with the entity (if found). If the entity is not found, Status Code 404 will be returned, otherwise 202 (OK) with the entity as json.

<p>To retrieve all of a single entity, send a <code>GET</code> request to <code>/api/{entityName}</code>.
<p>Some example curl calls:
<pre>
curl -iX GET localhost:8080/my-brews/api/beer
curl -iX GET localhost:8080/my-brews/api/beer/1
</pre>

<p>The first call will retrieve all beers and the second call will attempt to find beer with id 1. Since there currently is no data for beer, try these curl requests (constants).
<pre>
curl -iX GET localhost:8080/my-brews/api/beerstyle
curl -iX GET localhost:8080/my-brews/api/beercolor/1
</pre>
<p>The first call will retrieve all beer styles and the other call will return the beer color with id 1.

<h4>Creating Data</h4>
<p>Any entity can be created by sending a <code>POST</code> request to <code>/api/{entityName}</code>. I know, I know, no security :) That will change later..
<p>An example curl call:
<pre>
curl -H "Content-Type: application/json" \
     -d '{"name": "Wyeast #1332 Northwest Ale Yeast", "type": "LIQUID"}' \
     localhost:8080/my-brews/api/yeast
</pre>
<p>This will create a new yeast with the name and given Yeast Type. We can use our fancy get request and view the new yeast we made. <pre>
curl -iX GET localhost:8080/my-brews/api/yeast/1
</pre>

<h4>Updating Data</h4>
<p>An entity can be updated by sending a <code>PUT</code> request to <code>/api/{entityName}</code> (This might get updated later to pass in the id as well.. ex: <code>/api/{entityName}/{id}</code>).

<p>An example update of the yeast we just created:<pre>
curl -H "Content-Type: application/json" \
     -X PUT -d '{"id": "1", "name": "Wyeast #1332 Northwest Ale Yeast", "type": "DRY"}' \
     localhost:8080/my-brews/api/yeast
</pre>
<p>This updates the yeast we just created to have a DRY yeast type. Super exciting!

<h4>Deleting Data</h4>
<p>An entity can be deleted by sending a <code>DELETE</code> request to <code>/api/{entityName}/{id}</code>. So lets delete that yeast we just created:<pre>
curl -iX DELETE localhost:8080/my-brews/api/yeast/1
</pre>
<p>Wala! Magic!