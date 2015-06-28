var gulp = require('gulp'),
    browserify = require('browserify'),
    reactify = require('reactify'),
    source = require('vinyl-source-stream'),
    sass = require('gulp-ruby-sass'),
    autoprefixer = require('autoprefixer-core'),
    postcss = require('gulp-postcss'),
    rename = require('gulp-rename'),
    gulpif = require('gulp-if'),
    del = require('del'),
    argv = require('yargs').argv,
    uglify = require('gulp-uglify'),
    browserSync = require('browser-sync');


var isProduction = argv.production;

const APP_DIRS = {
  app: './src/main/app',
  js: './src/main/app/js',
  sass: './src/main/app/scss',
  main: './src/main/app/js/main.js',
  statics: [
    './src/main/app/**/*.+(png|jpg|jpeg|ico|json|html|mp3)',
  ],
};

const DIST_DIRS = {
  dist: './dist',
  css: './dist/css',
  js: './dist/js',
  fonts: './dist/fonts'
};

const EXTERNALS = [
  { require: 'react' },
  { require: 'react/addons' },
  { require: 'react/lib/keyMirror' },
  { require: 'react-router' },
  { require: 'jquery', expose: 'jquery' },
  { require: 'flux' },
  { require: 'events' },
  { require: 'underscore' },
  { require: 'request' },
];

const DEV_CONFIG = {
  sass: {
    style: 'expanded',
    //sourcemap: true,
    lineNumbers: true,
  },
  browserify: {
    debug: true, // enables source maps
  },
  autoprefixer: {
    browsers: ['last 2 version']
  },
};

const PROD_CONFIG = {
  sass: {
    style: 'compressed'
  },
  browserify: { },
  autoprefixer: {
    browsers: ['last 2 version']
  },
};

const CONFIG = isProduction != null ? PROD_CONFIG : DEV_CONFIG;



  /* Clean the dist folder */
gulp.task('clean', function() {
  return del([DIST_DIRS.dist]);
});


  /* Copy all the fonts into the fonts folder */
gulp.task('fonts', function() {
  return gulp.src('node_modules/font-awesome/fonts/*')
    .pipe(gulp.dest(DIST_DIRS.fonts));
});


  /* Copy all the statics into the dist folder */
gulp.task('statics', function() {
  return gulp.src(APP_DIRS.statics, { base: APP_DIRS.app })
    .pipe(gulp.dest(DIST_DIRS.dist));
});
gulp.task('statics-watch', ['statics'], browserSync.reload);



  /* Compile the scss files, copy to dist folder, and if not production, auto inject css instead of reload */
gulp.task('styles', function() {
  return sass(APP_DIRS.sass, CONFIG.sass)
    .pipe(postcss([
      autoprefixer(CONFIG.autoprefixer),
    ]))
    .pipe(gulpif(isProduction, rename({ suffix: '.min' })))
    .pipe(gulp.dest(DIST_DIRS.css))
    .pipe(gulpif(!isProduction, browserSync.stream()));
});
gulp.task('styles-watch', ['styles']);


function bundle(b, fileName, type) {
  return b.bundle()
    .on('error', function(err) {
      console.error('[' + type + ' ERROR]', err.message);
      this.emit('end');
    })
    .pipe(source(fileName))
    .pipe(gulpif(argv.producion, uglify()))
    .pipe(gulpif(argv.production, rename({ suffix: '.min' })))
    .pipe(gulp.dest(DIST_DIRS.js));
}

  /* Bundle the 3rdparty scripts to be used from the main app */
gulp.task('3rdparty-scripts', function() {
  var vendors = browserify();
  EXTERNALS.forEach(function(external) {
    if(external.expose) {
      vendors.require(external.require, { expose: external.expose });
    } else {
      vendors.require(external.require);
    }
  });

  return bundle(vendors, '3rdparty.js', '3RDPARTY');


});
gulp.task('3rdparty-scripts-watch', ['3rdparty-scripts'], browserSync.reload);


gulp.task('scripts', function() {
  var b = browserify(CONFIG.browserify);
  b.add(APP_DIRS.main);

  EXTERNALS.forEach(function(external) {
    if(external.expose) {
      b.external(external.expose);
    } else {
      b.external(external.require);
    }
  });
  
  return bundle(b, 'main.js', 'MAIN');
});
gulp.task('scripts-watch', ['scripts'], browserSync.reload);




/* Distribute the application with all files into the dist folder */
gulp.task('dist', ['scripts', '3rdparty-scripts', 'styles', 'fonts', 'statics']);


/* Start up browsersync and start watching files */
gulp.task('serve', ['dist'], function() {
  browserSync({
    server: {
      baseDir: DIST_DIRS.dist
    }
  });

  gulp.watch(APP_DIRS.js + '/**/*.js', ['scripts-watch']);
  gulp.watch(APP_DIRS.sass + '/**/*.scss', ['styles-watch']);
  gulp.watch(APP_DIRS.statics, ['statics-watch']);
});


gulp.task('default', ['serve']);
