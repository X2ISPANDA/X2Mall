## Vue

**计算属性和侦听器**

- computed：添加计算属性
- watch：监控属性

**过滤器**

- filters或者Vue.filter

**组件化**

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=<device-width>, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <script src="./node_modules/vue/dist/vue.js"></script>
    <div id="app">
        <button v-on:click="count++">我被点击了{{count}}次</button>
        <counter></counter>
        <button-counter></button-counter>
    </div>

    
    <script>
        //1.全局声明一个组件
        Vue.component("counter",{
            template: '<button v-on:click="count++">我被点击了{{count}}次</button>',
            data(){
                return {
                    count: 0
                }
            }
        });


        //2.局部聲明一個組件
        const buttonCounter= {
            template: '<button v-on:click="count++">我被点击了{{count}}次~~~~~~~~~~~~~</button>',
            data(){
                return {
                    count: 0
                }
            }
        }

        new Vue({
            el: "#app",
            data: {
                count: 0
            },
            components:{
                'button-counter': buttonCounter
            }
        })
    </script>
</body>
</html>
```

### Vue的生命周期和钩子函数

### Vue模块化开发

node安装webpack和vuecli

```vue
<template>
    <div>
        <h1>你好，Hello,{{name}}</h1>
    </div>
</template>

<script>
export default {
    data(){
        return {
            name: "张三"
        }
    }
}
</script>

<style>
    
</style>
```

```js
import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Hello from '@/components/Hello'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/hello',
      name: 'Hello',
      component: Hello
    }
  ]
})

```

添加路由视图

```html
<router-link to="/foo">Go to Foo</router-link>
```

### 整合ElementUI

安装

```shell
npm i element-ui -S
```

[参看开发文档即可](https://element.eleme.cn/#/zh-CN/component/installation)