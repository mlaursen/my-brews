var fs = require('fs');
var path = require('path');

var APP = 'src/main/app';
var CONFIG = APP + '/js/config.js';
var EXAMPLE_CONFIG = APP + '/js/config.example.js';


console.log('Copying the example config file.\n');
fs.createReadStream(EXAMPLE_CONFIG)
  .pipe(fs.createWriteStream(CONFIG))
  .on('error', function(err) {
    console.error(err.message);
    throw err;
  });
console.log('Your configuration file has been copied with the defaults.');
console.log('Please modify \'%s\' if you are not running your webservices on localhost.', CONFIG);



var LINKS = [
  {
    source: 'node_modules/bootstrap-sass/assets/stylesheets',
    target: APP + '/scss/vendors/bootstrap',
    type: 'dir',
    name: 'bootstrap',
  },
  {
    source: 'node_modules/normalize-scss-vanilla',
    target: APP + '/scss/vendors/normalize-scss-vanilla',
    type: 'dir',
    name: 'normalize-scss-vanilla',
  },
  {
    source: 'node_modules/font-awesome/scss',
    target: APP + '/scss/vendors/font-awesome',
    type: 'dir',
    name: 'font-awesome',
  },
];

console.log('Creating symlinks for:\n%s\n', LINKS.map(function(link) { return link.name; }).join(', '));
LINKS.forEach(function(link) {
  var source = path.resolve(link.source);
  var target = path.resolve(link.target);

  fs.unlink(target, function(err) {
    if(err && err.code != 'ENOENT') {
      throw err;
    }
  });

  fs.symlink(source, target, link.type, function(err) {
    if(err) {
      if(err.code == 'EPERM') {
        console.error('You must run this as administrator in Windows to create symlinks.');
        console.error('You can run \'npm run symlinks\' once you open an admin terminal');
      }
      throw err;
    }
  });
});
console.log('Symlinks have been create successfully for the scss vendors.\n');


