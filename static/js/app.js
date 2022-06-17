const Product = { template: '<edit-product></edit-product>' }
const Products = { template: '<products></products>' }
const Login = { template: '<login></login>' }
const Users = { template: '<users></users>' }
const Register = { template: '<register></register>'}
 
const router = new VueRouter({
	mode: 'hash',
	  routes: [
		{ path: '/', name: 'home', component: Login},
		{ path: '/users/', component: Users},
		{ path: '/register/', component: Register},
	    { path: '/products/:id', component: Product}
	  ]
});

var app = new Vue({
	router,
	el: '#login'
});