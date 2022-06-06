<template>
  <img alt="Vue logo" src="./assets/logo.png">
  <div>
    <button @click="fetchData">get Data!</button>
  </div>

  <div class="webtoons" v-for="(webtoon, i) in naverWebtoons" :key="i">
    <text>{{webtoon.title}}</text>
    <img :src="webtoon.thumbnail">
  </div>

  <div>
    <button @click="fetchNaver">get Naver Webtoon !</button>
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
      naverWebtoons : [],
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
      console.log(response)
  }).catch(function (error){
    console.log(error);
  })
  },

    fetchNaver: function (){
      axios.get('/naver')
      .then(res => {
        this.naverWebtoons = res.data;
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
