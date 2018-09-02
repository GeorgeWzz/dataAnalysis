<template>
  <div>
    <li>
        <a
          href='http://www.yuexiu-finance.com/'
          target="_blank"
        >
          越秀金控官网2018
        </a>
    </li>
    
    <h1>{{ msg }}</h1>
    <h1>{{ title }}</h1>
  <el-form label-width="80px">
    <el-form-item label="活动名称">
      <el-input v-model="name"></el-input>
    </el-form-item>
  </el-form>
    <el-input placeholder="请输入存储过程名称" v-model="procedureNameInput" clearable>
      <el-button type="primary" icon="el-icon-search" slot="append" @click="msgAdd">搜索</el-button>
    </el-input>
    <div>
      <v-table
              :width="1000"
              :columns="columns"
              :table-data="tableData"
              :show-vertical-border="false"
      ></v-table>
    </div>
  </div>
</template>

<script>
import Vue from 'vue'
import VueResource from 'vue-resource'
// 引入样式
import 'vue-easytable/libs/themes-base/index.css'
// 导入 table 和 分页组件
import {VTable, VPagination} from 'vue-easytable'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

Vue.use(VueResource)
Vue.component(VTable.name, VTable)
Vue.component(VPagination.name, VPagination)
Vue.use(ElementUI)

export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: '审计中心',
      title: '作者：蔡芷茵',
      tableData: null,
      columns: [],
      procedureNameInput: '租赁业务台账_IRR低于公司标准',
      columnsTest: [
        {field: 'id', title: '项目编号', width: 300, titleAlign: 'center', columnAlign: 'center'},
        {field: 'name', title: '项目名称', width: 500, titleAlign: 'center', columnAlign: 'center'},
        {field: 'description', title: '项目状态', width: 100, titleAlign: 'center', columnAlign: 'center'}
      ]
    }
  },
  methods: {
    msgAdd: function () {
      let baseUrl = 'http://localhost:8081/procedure/procedure'
      let procedureName = this.procedureNameInput
      let url = baseUrl + '?procedureName=' + procedureName
      this.$http.get(url).then(
        response => {
          debugger
          console.log(response.data)
          var columnsArray = response.data.columns
          for (var i = 0; i < columnsArray.length; i++) {
            this.columns.push({field: columnsArray[i], title: columnsArray[i], width: 100, titleAlign: 'center', columnAlign: 'center'})
          }
          this.tableData = response.data.tableData
        },
        response => {
          console.log('error')
        })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1{
  font-weight: normal;
  font-size: 2ch;
  color: rgb(2, 2, 7);
}
h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: rgb(93, 96, 236);
}
</style>
