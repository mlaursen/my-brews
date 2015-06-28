var Beer = function(id, name, beerStyle, regionalStyle, color, description) {
  this.id = id;
  this.name = name;
  this.beerStyle = beerStyle;
  this.regionalStyle = regionalStyle;
  this.color = color;
  this.description = description;
};

Beer.fromJson = function(json) {
  return new Beer(json.id, json.name, json.beerStyle.name, json.regionalStyle.name, json.beerColor.name, json.description);
};

module.exports = Beer;
