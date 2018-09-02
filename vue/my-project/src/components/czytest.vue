<template>
<body>
  <div id="tab">
    <div class="tab-tit">
        <!--点击设置curId的值  如果curId等于0，第一个a添加cur类名，如果curId等于1，第二个a添加cur类名，以此类推。添加了cur类名，a就会改变样式 @click,:class ,v-show这三个是vue常用的指令或添加事件的方式-->
        <a href="javascript:;" @click="curId=0" :class="{'cur':curId===0}">金控本部</a>
        <a href="javascript:;" @click="curId=1" :class="{'cur':curId===1}">广州证券</a>
        <a href="javascript:;" @click="curId=2" :class="{'cur':curId===2}">越秀租赁</a>
        <a href="javascript:;" @click="curId=3" :class="{'cur':curId===3}">广州资产</a>
    </div>
    <div class="tab-con">
        <!--根据curId的值显示div,如果curId等于0，第一个div显示，其它三个div不显示。如果curId等于1，第二个div显示，其它三个div不显示。以此类推-->
        <div v-show="curId===0">
            金控本部业务数据列表<br/>
        </div>
        <div v-show="curId===1">
            广州证券业务数据列表
        </div>
        <div v-show="curId===2">
            越秀租赁业务数据列表
        </div>
        <div v-show="curId===3">
            广州资产业务数据列表
        </div>
    </div>
  </div>
</body>
</template>
<script src="vue.min.js"></script>
<script>
import Vue from 'vue'
import VueResource from 'vue-resource'
// 引入样式
import 'vue-easytable/libs/themes-base/index.css'
// 导入 table 和 分页组件
import {VTable, VPagination} from 'vue-easytable'

Vue.use(VueResource)
Vue.component(VTable.name, VTable)
Vue.component(VPagination.name, VPagination)

new Vue({
        el: '#tab',
        data: {
            curId: 0
        },
        computed: {},
        methods: {},
        mounted: function () {
        }
    })
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
 body{
        font-family:"Microsoft YaHei";
    }
    #tab{
        width: 600px;
        margin: 0 auto;
    }
    .tab-tit{
        font-size: 0;
        width: 600px;
    }
    .tab-tit a{
        display: inline-block;
        height: 40px;
        line-height: 40px;
        font-size: 16px;
        width: 25%;
        text-align: center;
        background: #ccc;
        color: #333;
        text-decoration: none;
    }
    .tab-tit .cur{
        background: #09f;
        color: #fff;
    }
    .tab-con div{
        border: 1px solid #ccc;
        height: 400px;
        padding-top: 20px;
    }
</style>
