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
					<th>Birthdate</th>
	    		</tr>	    			
	    		<tr v-for="(p, index) in users">
	    			<td>{{p.username}}</td>
	    			<td>{{p.password}}</td>
                    <td>{{p.name}}</td>
                    <td>{{p.surname}}</td>
					<td>{{p.birthDate}}</td>
	    		</tr>
	    	</table>
			<button v-on:click="viewobjects">View sports objects</button>
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