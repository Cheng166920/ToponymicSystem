<template>
<table>
      <tr>
        <td>编号</td>
        <td>图上名称</td>
        <td>类别代码</td>
        <td>使用时间</td>
      </tr>
  <tr v-for="test in tests" :key="test.gid">
        <td>{{test.gid}}</td>
        <td>{{test.图上名称}}</td>
        <td>{{test.类别代码}}</td>
        <td>{{test.使用时间}}</td>
      </tr>
      </table>
</template>

<script>
import axios from "axios"
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },
  data(){
    return {
      customers:'',
      tests:[]
    }
  },
  mounted() {
    var _this = this
    axios.get('/toponym/point/list').then(function (res){
      console.log(res.data)
      _this.tests = res.data
    }).catch( error => {
                console.log(error);
            });
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
