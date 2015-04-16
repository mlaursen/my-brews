var gulp = require('gulp'),
    browserify = require('gulp-browserify');
    sass = require('gulp-ruby-sass'),
    autoprefixer = require('gulp-autoprefixer'),
    minifycss = require('gulp-minify-css'),
    rename = require('gulp-rename'),
    path = require('path'),
    merge = require('merge-stream');

var srcDir = 'src/main/frontend';
var jsDir = srcDir + '/js';
var sassDir = srcDir + '/scss';

var libDir = 'bower_components';

var distDir = 'dist';
var distCssDir = distDir + '/css';
var distJsDir  = distDir + '/js';
var distLibDir = distDir + '/lib';
var distImgDir = distDir + '/imgs';

// Constant Configurations
var SASS_CONFIG = {
  style: 'expanded',
};
var BROWSERIFY_CONFIG = {
  insertGlobals: true,
  debug: !gulp.env.production
};
var MIN = {
  suffix: '.min'
};

// Compile sass files, auto-prefix elements,  copy to app's css directory
// and creates minified version as well
gulp.task('styles', function() {
  return sass(sassDir, SASS_CONFIG)
    //.pipe(autoprefixer('last 2 version', 'safari 5', 'ie 8', 'ie 9', 'opera 12.1'))
    .pipe(gulp.dest(distCssDir))
    .pipe(rename(MIN))
    .pipe(minifycss())
    .pipe(gulp.dest(distCssDir));
});


// Compiles the react files into a single app.js and copie it to the distribution folder
gulp.task('scripts', function() {
  return gulp.src(jsDir + '/app.js')
    .pipe(browserify(BROWSERIFY_CONFIG))
    .pipe(gulp.dest(distJsDir));
});


// Copies all the libs to the distribution folder
gulp.task('libs', function() {
  var bootstrap = gulp.src(libDir + '/bootstrap/dist/**/*')
    .pipe(gulp.dest(distLibDir + '/bootstrap'));

  var fontAwesomeCss = gulp.src(libDir + '/font-awesome/**/*.css')
    .pipe(gulp.dest(distLibDir + '/font-awesome'));

  var fontAwesomeFonts = gulp.src(libDir + '/font-awesome/fonts/*')
    .pipe(gulp.dest(distLibDir + '/font-awesome/fonts'));

  var jquery = gulp.src(libDir + '/jquery/dist/*.js')
    .pipe(gulp.dest(distLibDir + '/jquery'));

  var normalize = gulp.src(libDir + '/normalize-css/normalize.css')
    .pipe(gulp.dest(distLibDir + '/normalize-css'));

  return merge(bootstrap, fontAwesomeCss, fontAwesomeFonts, jquery, normalize);
});


// Copies all the html pages to the dist folder
gulp.task('pages', function() {
  return gulp.src(srcDir + '/**/*.html')
    .pipe(gulp.dest(distDir));
});


gulp.task('imgs', function() {
  return gulp.src(srcDir + '/imgs/**/*')
    .pipe(gulp.dest(distImgDir));
});


// builds the distribution package by copying all the libs, css, javascript files, and html pages to the dist folder.
gulp.task('dist', ['libs', 'styles', 'scripts', 'pages', 'imgs']);


// Watches files to auto compile and copy
gulp.task('watch', function() {
  // Watching for compiling
  gulp.watch(sassDir + '/**/*.scss', ['styles']);
  gulp.watch(jsDir + '/**/*.js', ['scripts']);
  gulp.watch(srcDir + '/**/*.html', ['pages']);

  // Watching to live reload
  gulp.watch(distDir + '/**/*.html', liveReload);
  gulp.watch(distCssDir + '/**/*.css', liveReload);
  gulp.watch(distJsDir + '/**/*.js', liveReload);
});



// Starts the development server on port 4000
gulp.task('express', function() {
  var express = require('express');
  var app     = express();
  app.use(require('connect-livereload')({port: 4002}));
  app.use(express.static(path.join(__dirname, distDir)));
  app.listen(4000);
});

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





gulp.task('default', ['dist', 'express', 'livereload', 'watch'], function() {

});
