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
	    			<th>Korisničko ime</th>
	    			<th>Lozinka</th>
                    <th>Ime</th>
	    			<th>Prezime</th>
					<th>Datum Rođenja</th>
	    		</tr>	    			
	    		<tr v-for="(p, index) in users">
	    			<td>{{p.username}}</td>
	    			<td>{{p.password}}</td>
                    <td>{{p.name}}</td>
                    <td>{{p.surname}}</td>
					<td>{{p.birthDate}}</td>
	    		</tr>
	    	</table>
			<button v-on:click="viewobjects">Prikaži sportske objekte</button>
    	</div>		  
    	`,
    mounted () {
        axios
          .get('rest/users/')
          .then(response => (this.users = response.data))
    },
    methods: {
    	viewobjects : function() {
    		router.push(`/sportsobjects/`);
    	}
    }
});