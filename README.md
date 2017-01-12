# WeCashier
open -source Cashier App(Android)
#Base on
  * rxjava
  * Dagger2
  * zxing 
#code tree
├── DB
│   └── DaoManager.java
├── MyApplication.java
├── base
│   ├── BaseActivity.java
│   ├── BaseFragment.java
│   ├── BaseMvpPresenter.java
│   ├── BaseMvpViewImp.java
│   ├── PresentLoader.java
│   ├── PresenterFactory.java
│   └── event
│       ├── Event.java
│       └── EventSticky.java
├── bean
│   ├── entity
│   │   ├── GOODS.java
│   │   └── ORDER.java
│   └── gen
│       ├── DaoMaster.java
│       ├── DaoSession.java
│       ├── GOODSDao.java
│       └── ORDERDao.java
├── domain
│   ├── business
│   │   ├── cashier
│   │   ├── manager
│   │   ├── scan
│   │   └── setting
│   └── main
│       ├── MainActivity.java
│       ├── MainModel.java
│       ├── MainMvpContract.java
│       └── MainPresenter.java
└── utills
├── Adapters
│   └── FragmentAdapter.java
├── BusAction.java
├── Constants.java
├── DateTimePickDialogUtil.java
├── DateUtil.java
├── StringUtil.java
├── SysUtil.java
├── ToastUtil.java
├── rxbluetooth
│   └── RxBlueTooth.java
└── rxbus
├── RxBus.java
└── RxBusSubscriber.java
