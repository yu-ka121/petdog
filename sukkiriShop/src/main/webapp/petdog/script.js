//星を作る関数。n は星の個数。多いほど星が多く振ります。
function starMaker(n) {
    var star = document.createElement("div");
    star.className = "star";
    star.textContent = "🎵";
    for(var i = 0; i < n; i++) {
        starSet(star);
    }
}

//星のセッティングをする関数。
function starSet(clone) {
    var starClone = clone.cloneNode(true);
    var starStyle = starClone.style;

    //星の位置（left）、アニメーションの遅延時間（animation-delay）、サイズ（font-size）をランダムで指定
    starStyle.left = 100 * Math.random() + "%";
    starStyle.animationDelay = 8 * Math.random() + "s";
    starStyle.fontSize = ~~(50 * Math.random() + 20) + "px";
    document.body.appendChild(starClone);

    //星一つのアニメーションが終わったら新しい星を生成
    starClone.addEventListener("animationend", function() {
        this.parentNode.removeChild(this);
        var star = document.createElement("div");
        star.className = "star";
        star.textContent = "🌟";
        starSet(star);
    }, false)
}

//使用例。星を20個ふらせます。
starMaker(20)

particlesJS("particles-js", {
    "particles":{
      "number":{
        "value":346,//この数値を変更すると星の数が増減できる
        "density":{
          "enable":true,
          "value_area":800
        }
      },
      "color":{
        "value":"#ffffff"
      },
      "shape":{
        "type":"circle",//形状はcircleを指定
        "stroke":{
          "width":0
        },
        },
      "opacity":{
        "value":1,//シェイプの透明度
        "random":true,//シェイプの透明度をランダムにする
        "anim":{
          "enable":true,//シェイプの透明度をアニメーションさせる
          "speed":3,//シェイプの透明度をアニメーションさせる
          "opacity_min":0,//透明度の最小値０
          "sync":false//全てを同時にアニメーションさせない
        }
      },
      "size":{
        "value":2,
        "random":true,
        "anim":{
          "enable":false,
          "speed":4,
          "size_min":0.3,
          "sync":false
        }
      },
      "line_linked":{
        "enable":false,
      },
      "move":{
        "enable":true,
        "speed":120,//この数値を小さくするとゆっくりな動きになる
      "direction":"none",//方向指定なし
      "random":true,//動きはランダムに
      "straight":true,//動きをとどめる
        "out_mode":"out",
        "bounce":false,
        "attract":{
          "enable":false,
          "rotateX":600,
          "rotateY":600
        }
      }
    },
    "interactivity":{
      "detect_on":"canvas",
      "events":{
        "onhover":{
          "enable":false,
        },
        "onclick":{
          "enable":false,
        },
        "resize":true
      }
    },
    "retina_detect":true
  });
  
  function audio() {
    document.getElementById('btn_audio').currentTime = 0; //連続クリックに対応
    document.getElementById('btn_audio').play(); //クリックしたら音を再生
}
