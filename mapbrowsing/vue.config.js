const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true, 
  devServer: {
    proxy: {
        '/toponym': {
            target: 'http://localhost:8080',
            changeOrigin: true
            }
        }
    }
})
