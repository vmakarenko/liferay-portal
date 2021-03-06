Liferay.Loader.define("hello-soy-web@1.0.4/Header.soy", ['exports', 'metal-component/src/Component', 'metal-soy/src/Soy'], function (exports, _Component2, _Soy) {
  'use strict';

  Object.defineProperty(exports, "__esModule", {
    value: true
  });
  exports.templates = exports.Header = undefined;

  var _Component3 = _interopRequireDefault(_Component2);

  var _Soy2 = _interopRequireDefault(_Soy);

  function _interopRequireDefault(obj) {
    return obj && obj.__esModule ? obj : {
      default: obj
    };
  }

  function _classCallCheck(instance, Constructor) {
    if (!(instance instanceof Constructor)) {
      throw new TypeError("Cannot call a class as a function");
    }
  }

  function _possibleConstructorReturn(self, call) {
    if (!self) {
      throw new ReferenceError("this hasn't been initialised - super() hasn't been called");
    }

    return call && (typeof call === "object" || typeof call === "function") ? call : self;
  }

  function _inherits(subClass, superClass) {
    if (typeof superClass !== "function" && superClass !== null) {
      throw new TypeError("Super expression must either be null or a function, not " + typeof superClass);
    }

    subClass.prototype = Object.create(superClass && superClass.prototype, {
      constructor: {
        value: subClass,
        enumerable: false,
        writable: true,
        configurable: true
      }
    });
    if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass;
  }

  var templates;
  goog.loadModule(function (exports) {

    // This file was automatically generated from Header.soy.
    // Please don't edit this file by hand.

    /**
     * @fileoverview Templates in namespace Header.
     * @public
     */

    goog.module('Header.incrementaldom');

    /** @suppress {extraRequire} */
    var soy = goog.require('soy');
    /** @suppress {extraRequire} */
    var soydata = goog.require('soydata');
    /** @suppress {extraRequire} */
    goog.require('goog.i18n.bidi');
    /** @suppress {extraRequire} */
    goog.require('goog.asserts');
    var IncrementalDom = goog.require('incrementaldom');
    var ie_open = IncrementalDom.elementOpen;
    var ie_close = IncrementalDom.elementClose;
    var ie_void = IncrementalDom.elementVoid;
    var ie_open_start = IncrementalDom.elementOpenStart;
    var ie_open_end = IncrementalDom.elementOpenEnd;
    var itext = IncrementalDom.text;
    var iattr = IncrementalDom.attr;

    /**
     * @param {Object<string, *>=} opt_data
     * @param {(null|undefined)=} opt_ignored
     * @param {Object<string, *>=} opt_ijData
     * @return {void}
     * @suppress {checkTypes}
     */
    function $render(opt_data, opt_ignored, opt_ijData) {
      /** @desc  */
      var MSG_EXTERNAL_4961493287620807008 = Liferay.Language.get('welcome-to-x');
MSG_EXTERNAL_4961493287620807008 = MSG_EXTERNAL_4961493287620807008.replace('{0}', opt_data.releaseInfo);
      var msg_s138 = MSG_EXTERNAL_4961493287620807008;
      ie_open('blockquote', null, null, 'class', 'blockquote-primary');
      ie_open('p');
      itext(msg_s138);
      ie_close('p');
      ie_close('blockquote');
    }
    exports.render = $render;
    if (goog.DEBUG) {
      $render.soyTemplateName = 'Header.render';
    }

    exports.render.params = ["releaseInfo"];
    exports.render.types = { "releaseInfo": "any" };
    exports.templates = templates = exports;
    return exports;
  });

  var Header = function (_Component) {
    _inherits(Header, _Component);

    function Header() {
      _classCallCheck(this, Header);

      return _possibleConstructorReturn(this, (Header.__proto__ || Object.getPrototypeOf(Header)).apply(this, arguments));
    }

    return Header;
  }(_Component3.default);

  _Soy2.default.register(Header, templates);
  exports.Header = Header;
  exports.templates = templates;
  exports.default = templates;
});
//# sourceMappingURL=Header.soy.js.map