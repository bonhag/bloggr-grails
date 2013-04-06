App = Ember.Application.create();

App.Store = DS.Store.extend({
  revision: 12,
  adapter: DS.RESTAdapter.extend({
    url: '/bloggr'
  })
});

App.Router.map(function() {
	this.resource('posts', function() {
		this.resource('post', { path: ':post_id' });
	});
  this.resource('about');
});

App.IndexRoute = Ember.Route.extend({
  redirect: function() {
    this.transitionTo('posts');
  }
});

App.PostsRoute = Ember.Route.extend({
	model: function() {
		return App.Post.find();
	}
});

// Single object because the PostController represents a single model,
// not a collection of models

App.PostController = Ember.ObjectController.extend({
  isEditing: false,

  doneEditing: function() {
    this.set('isEditing', false);
  },

  edit: function() {
    this.set('isEditing', true);
  }
});

App.Post = DS.Model.extend({
	title: DS.attr('string'),
	author: DS.attr('string'),
	intro: DS.attr('string'),
	extended: DS.attr('string'),
	publishedAt: DS.attr('date')
});

Ember.Handlebars.registerBoundHelper('date', function(date) {
	return moment(date).fromNow();
});

var showdown = new Showdown.converter();

Ember.Handlebars.registerBoundHelper('markdown', function(input) {
	return new Ember.Handlebars.SafeString(showdown.makeHtml(input));
});
