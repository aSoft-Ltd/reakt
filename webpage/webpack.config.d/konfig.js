config.resolve.modules.push("/media/andylamax/63C23C360914D355/aSoft/OSS Libs/reakt/code/webpage/build/resources/main")
config.module.rules.push({
    test: /\.(png|jpe?g|gif|svg)$/i,
    use: [
      {
        loader: 'file-loader',
      },
    ],
});