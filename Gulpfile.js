var gulp = require('gulp'),
    browserify = require('gulp-browserify');
    sass = require('gulp-ruby-sass'),
    autoprefixer = require('gulp-autoprefixer'),
    minifycss = require('gulp-minify-css'),
    rename = require('gulp-rename'),
    path = require('path');

var tinylr;
gulp.task('livereload', function() {
  tinylr = require('tiny-lr')();
  tinylr.listen(4002);
});


function liveReload(event) {
  var fileName = path.relative(__dirname, event.path);

  tinylr.changed({
    body: {
      files: [fileName]
    }
  });
}

var srcDir = 'src/main/frontend';
var sassDir = srcDir + '/scss';
var cssDir = srcDir + '/css';
var jsDir = srcDir + '/js';
var compiledJSX = 'build/js';

var SASS_CONFIG = {
  style: 'expanded',
  //includePaths: [srcDir + '/lib']
};

// Compile sass files, auto-prefix elements,  copy to app's css directory
// and creates minified version as well
gulp.task('css', function() {
  return sass(sassDir, SASS_CONFIG)
    //.pipe(autoprefixer('last 2 version', 'safari 5', 'ie 8', 'ie 9', 'opera 12.1'))
    .pipe(gulp.dest(cssDir))
    .pipe(rename({ suffix: '.min'}))
    .pipe(minifycss())
    .pipe(gulp.dest(cssDir));
});


// Watches files to auto compile and copy
gulp.task('watch', function() {
  gulp.watch(sassDir + '/**/*.scss', ['css']);
  gulp.watch(srcDir + '/**/*.html', liveReload);
  gulp.watch(cssDir + '/**/*.css', liveReload);
  gulp.watch([jsDir + '/**/*.js', '!' + jsDir + '/bundle.js'], ['bundle']);
  gulp.watch(jsDir + '/bundle.js', liveReload);
});


// Uses browserify to convert/compile jsx files using the app.js single source.
// Outputs the built javascript file into build/
gulp.task('build', function() {
return gulp.src(jsDir + '/app.js')
      .pipe(browserify({
        insertGlobals: true,
        debug: !gulp.env.production
      }))
      .pipe(gulp.dest(compiledJSX));
});

// Takes the built javascript file and moves it to bundle.js in the active directory.. Prolly
// a better way to do this.
gulp.task('bundle', ['build'], function() {
  return gulp.src(compiledJSX + '/app.js')
      .pipe(rename('bundle.js'))
      .pipe(gulp.dest(jsDir));
});


// Starts the development server on port 4000
gulp.task('express', function() {
  var express = require('express');
  var app     = express();
  app.use(require('connect-livereload')({port: 4002}));
  app.use(express.static(path.join(__dirname, 'src/main/frontend')));
  app.listen(4000);
});




gulp.task('default', ['css', 'bundle', 'express', 'livereload', 'watch'], function() {

});
