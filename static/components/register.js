Vue.component("register", { 
	data: function () {
	    return {
          users: null,
          user: {username:null, password:null, name:null, surname:null, gender:null, date:null, type:'Customer'}
	    }
	},
	    template: ` 
    	<div>
            <form id="forma">
                <table>
                    <tr><td>Name:</td><td><input type="text" v-model = "user.name" name="name"></td></tr>
                    <tr><td>Surname:</td><td><input type="text" v-model = "user.surname" name="surname"></td></tr>
                    <tr><td>Gender:</td><td><input type="text" v-model = "user.gender" name="gender"></td></tr>
                    <tr><td>Birth date:</td><td><input type="date" v-model = "user.date" name="date"></td></tr>
                    <tr><td>Username:</td><td><input type="text" v-model = "user.username" name="username"></td></tr>
                    <tr><td>Password:</td><td><input type="password" v-model = "user.password" name="password"></td></tr>
                    <tr><td><button v-on:click="register">Register</button></td></tr>
                </table>
            </form>
    	</div>		  
    	`,
    mounted () {
        axios
          .get('rest/users/')
          .then(response => (this.users = response.data))       
    },
    methods: {
    	register : function() {  
            let b = false;          
            this.users.forEach(user => {                
                if(user.username==this.username){
                    b=true;
                    console.warn('Username is taken!')
                }              
            });
            if(!b)
            {
                axios.post('rest/users/add', this.user)
                router.push(`/users/`)
            }   		
    	}	
    }
});