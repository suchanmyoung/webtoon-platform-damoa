<template>
  <img alt="Vue logo" src="./assets/logo.png">
  <div>
    <button @click="fetchData">get Data!</button>
  </div>

  <form id="myForm" @submit.prevent="sendPost">
    <input type="text" name="title" v-model="title">
    <button>Send</button>
  </form>
</template>

<script>

import axios from "axios";

export default {
  name: 'App',
  components: {
  },
  data(){
    return{
      title : "hello",
    }
  },
  methods: {
    fetchData: function(){
      axios.get('/hello')
      .then(function (response){
        console.log(response);
      })
      .catch(function (error){
        alert(error);
      });
    },

    sendPost: function() {
    axios.post('/binding', {
      title: this.title
    })
    .then(function(response){
      console.log(response.data);
  }).catch(function (error){
    console.log(error);
  })
  }
},
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
