<template>
    <div class="modelBox Btn">
        <div>
          <router-link v-if="prev" class="npBtn prev" tag="div" :to="{name: 'flowPath' + prev}"></router-link>
          <router-link v-if="next && next != 6" class="npBtn next" tag="div" :to="{name: 'flowPath' + next}" @click.native="taskChange(next)"></router-link>
          <div v-else class="npBtn next" @click="taskPay()"></div>
        </div>
    </div>
</template>

<script>
import { mapMutations } from 'vuex'

export default {
  name: 'TaskModel',
  data () {
    return {
      newPrev: this.prev
    }
  },
  props: {
    next: {
        type: Number
    },
    prev: {
        type: Number
    }
  },
  methods: {
      ...mapMutations(["taskChange"]),
      taskPay(){
        this.$emit('showFlow');
      },
      subChange(){
        this.newPrev = 11
      },
      taskChange(){
        //调用父组件的保存方法
        this.$parent.saveData()
      }
  }
}
</script>

<style scoped>

</style>
