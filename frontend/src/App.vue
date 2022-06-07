<template>
  <nav class="navbar navbar-dark bg-dark">
    <button @click="fetchNaver" type="button" class="btn btn-success">네이버웹툰</button>
    <button type="button" class="btn btn-warning">카카오웹툰</button>
    <button type="button" class="btn btn-danger">레진코믹스</button>
  </nav>

  <div class="webtoons">
    <div class="webtoon" v-for="(webtoon, i) in naverWebtoons" :key="i">
      <img :src="webtoon.thumbnail">
      <text class="webtoon_title">{{webtoon.title}}</text>
    </div>
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
.webtoons {
  justify-content: space-between;
  flex-wrap: wrap;
  display: flex;
  align-items: center;
}

.webtoon {
  width: 150px;
  height: 150px;
  align-items: center;
}

.webtoon img{
  width: 120px;
  height:  120px;
  object-fit: cover;
}

.webtoon text {
  display: block;
  text-align: center;
  width: 120px;
  height: 120px;
  white-space: nowrap;
  overflow: hidden;
  text-overflow : ellipsis;
}

</style>
