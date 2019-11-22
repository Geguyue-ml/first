<template>
    <div class="modelBox Btn">
        <div>
            <router-link v-if="prev" class="npBtn prev" tag="div" :to="{name: 'flowPath' + prev}" @click.native="taskOk(prev)"></router-link>
            <router-link v-if="next" class="npBtn next" tag="div" :to="{name: 'flowPath' + next}" @click.native="taskOk(next)"></router-link>
        </div>
    </div>
</template>

<script>
import { mapMutations } from 'vuex'

export default {
  name: 'TaskModel',
  data () {
    return {
      
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
      ...mapMutations(["taskOk"])
  }
}
</script>

<style scoped>

</style>
