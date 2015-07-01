var fs = require('fs');
var path = require('path');

var LINKS = [
  {
    source: 'node_modules/bootstrap-sass/assets/stylesheets',
    target: 'src/main/app/scss/vendors/bootstrap',
    type: 'dir',
  },
  {
    source: 'node_modules/normalize-scss-vanilla',
    target: 'src/main/app/scss/vendors/normalize-scss-vanilla',
    type: 'dir',
  },
  {
    source: 'node_modules/font-awesome/scss',
    target: 'src/main/app/scss/vendors/font-awesome',
    type: 'dir',
  },
];

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
        console.log('You must run this as administrator in Windows to create symlinks');
        return false;
      }
      throw err;
    }
  });
});
