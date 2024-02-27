<template>
  <div>
    <div class="menu">
       <!-- <a v-for="header in 3" :key="header">Home</a> -->
    <!-- <a v-for="(menu,i) in menus" :key="i">{{ menu }}</a> -->
    <a v-for="menu in menus" :key="menu">{{ menu }}</a>
      </div>

      <div class="minions" v-for="(agency,key) in agencys" :key="key">
        <img :src="agency.imgSrc">
        <h3>{{ agency.name}}</h3>
        <p>{{ agency.company}}</p>
        <button @click="onClickLikes(key)">좋아요</button>
        <span>좋아요{{agency.likes }}</span>
      </div>
   
   
  </div>
</template>

<script>
export default {
  data () {
    

    return {
      menus:['Home','Minions','About'],
      agencys:[{name:'미니언즈1',company:'미니언',likes:0,imgSrc:require('./assets/images/01.png')},
      {name:'미니언즈2',company:'미니언',likes:0,imgSrc:require('./assets/images/02.png')},
      {name:'미니언즈3',company:'미니언',likes:0,imgSrc:require('./assets/images/04.png')},
      {name:'미니언즈4',company:'미니언',likes:0,imgSrc:require('./assets/images/05.png')},
      {name:'미니언즈5',company:'미니언',likes:0,imgSrc:require('./assets/images/07.png')}]
    }
  },
  methods:{
    onClickLikes(num){
      this.agencys[num].likes++;
    }
  }
}
</script>

<style lang="css" scoped>

.menu{
  background-color: lightskyblue;
  padding:10px;
  border-radius: 5px;
}

.menu a{
  color: white;
  font-weight: bold;
  padding: 10px;

}

.minions img{
  margin-top: 30px;
}

</style>
