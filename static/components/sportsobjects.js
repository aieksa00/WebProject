Vue.component("sportsobjects", { 
	data: function () {
	    return {
	      objects: null
	    }
	},
	    template: ` 
    	<div>
    		<h2>Prikaz sportskih objekata</h2>
            <table border="1">
	    		<tr bgcolor="lightgrey">
	    			<th>Name</th>
	    			<th>Object Type</th>
                    <th>Description</th>
	    			<th>Status</th>
					<th>Location</th>
					<th>Rating</th>
					<th>Working Hours</th>
	    		</tr>	    			
	    		<tr v-for="(o, index) in objects">
	    			<td>{{o.name}}</td>
	    			<td>{{o.objectType}}</td>
                    <td>{{o.description}}</td>
                    <td>{{o.status}}</td>
					<td>{{o.location}}</td>
					<td>{{o.rating}}</td>
					<td>{{o.workingHours}}</td>
	    		</tr>
	    	</table>
    	</div>		  
    	`,
    mounted () {
        axios
          .get('rest/sportsobjects/')
          .then(response => (this.objects = response.data))
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