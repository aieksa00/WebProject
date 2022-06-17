Vue.component("users", { 
	data: function () {
	    return {
	      users: null
	    }
	},
	    template: ` 
    	<div>
    		<h3>Prikaz korisnika</h3>
    		<table border="1">
	    		<tr bgcolor="lightgrey">
	    			<th>Username</th>
	    			<th>Password</th>
                    <th>Name</th>
	    			<th>Surname</th>
	    		</tr>	    			
	    		<tr v-for="(p, index) in users">
	    			<td>{{p.username}}</td>
	    			<td>{{p.password}}</td>
                    <td>{{p.name}}</td>
                    <td>{{p.surname}}</td>
	    		</tr>
	    	</table>
    		<button v-on:click = "addProduct">Dodaj nov proizvod</button>
    	</div>		  
    	`,
    mounted () {
        axios
          .get('rest/users/')
          .then(response => (this.users = response.data))
    },
    methods: {
    	addProduct : function() {
    		router.push(`/products/-1`);
    	},
    	editProduct : function(id) {
    		router.push(`/products/${id}`);
    	},
    	deleteProduct : function(id, index) {
    		r = confirm("Are you sure?")
    		if (r){
	    		axios
	            .delete('rest/products/delete/' + id)
	            .then(response => (this.products.splice(index, 1)))
    		}
    	}
    }
});