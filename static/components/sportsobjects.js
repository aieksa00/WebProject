Vue.component("sportsobjects", { 
	data: function () {
	    return {
	      objects: null
	    }
	},
	    template: ` 
    	<div>
    		<h2>Prikaz sportskih objekata</h2>
            <ul>
                <li v-for="(o,index) in objects">
                    {{o.name}}
                </li>
            </ul>
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