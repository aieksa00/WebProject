Vue.component("login", { 
	data: function () {
	    return {
	      username: null,
          password: null,
          users: null
	    }
	},
	    template: ` 
    	<div>
            <form id="forma">
                <table>
                    <tr><td>Username</td><td><input type="text" v-model = "username" name="username"></td></tr>
                    <tr><td>Password</td><td><input type="password" v-model = "password" name="password"></td></tr>
                    <tr><td><button v-on:click="login">Izmeni</button></td></tr>
                </table>
                <p id="error"></p>
                <p id="success"></p>
            </form>
    	</div>		  
    	`,
    mounted () {
        axios
          .get('rest/users/')
          .then(response => (this.users = response.data))       
    },
    methods: {
    	login : function() {  
            let b = false;          
            this.users.forEach(user => {                
                if(user.username==this.username && user.password==this.password){
                    b=true;
                    router.push(`/users/`);
                }              
            });
            if(!b)
                console.log('Wrong username or password');
    		
    	}    	
    }
});